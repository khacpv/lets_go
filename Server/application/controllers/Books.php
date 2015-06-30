<?php
/**
 * Created by PhpStorm.
 * User: khacpham
 * Date: 6/29/15
 * Time: 01:14
 */

class Books extends CI_Controller{
  public function __construct()
  {
    parent::__construct();
    $this->load->helper('url');
    $this->load->library('session');

    $this->load->model('book_model');
    $this->load->model('category_model');

    if (!$this->session->userdata('email')) {
      header("Location: ".base_url()."login.html");
    }
  }

  public function index(){
    redirect('/books/create');
  }

  public function delete($bookId){
    $this->book_model->delete($bookId);
    redirect('/books/create');
  }

  public function create()
  {
    $config['upload_path'] = './blob/';
    $config['allowed_types'] = 'gif|jpg|png';
    $config['max_size']	= '1000';
    $config['max_width']  = '1080';
    $config['max_height']  = '1920';

    $this->load->library('upload', $config);
    $this->load->library('form_validation');
    $this->load->helper('form');

    $data['title'] = 'Create a book';
    $data['username'] = $this->session->userdata('username');
    $data['email'] = $this->session->userdata('email');
    $data['error'] = '';
    $data['books'] = $this->book_model->get_books('',100,0);
    $data['categories'] = $this->category_model->get_categories('',100,0);
    $data['categoryId'] = $this->session->userdata('categoryId');

    $this->form_validation->set_rules('title', 'Title', 'required');
    $this->form_validation->set_rules('author', 'Author', 'required');
    $this->form_validation->set_rules('description', 'Description', 'required');
    $this->form_validation->set_rules('isbn13', 'Isbn13', 'required');

    // insert book
    if ($this->form_validation->run() === FALSE) {
      $this->load->view('templates/header', $data);
      $this->load->view('books/create');
      $this->load->view('books/list',$data);
      $this->load->view('templates/footer');
    } else {
      // upload image first
      if ( ! $this->upload->do_upload('thumbnail'))
      {
        $error = $this->upload->display_errors();
        $data['error'] = $error;

        $this->load->view('templates/header', $data);
        $this->load->view('books/create');
        $this->load->view('books/list',$data);
        $this->load->view('templates/footer');
      }
      else
      {
        $imgUpload = $this->upload->data();
        $this->load->helper('imagesize_helper');
        smart_resize_image($imgUpload['full_path'],null,300,450,false,$imgUpload['full_path'],true,false,100);

        $this->session->set_userdata('categoryId', $this->input->post('categoryId'));

        $book = (object)array(
          'title' => $this->input->post('title'),
          'author' => $this->input->post('author'),
          'description' => $this->input->post('description'),
          'tag' => $this->input->post('tag'),
          'categoryId' => $this->input->post('categoryId'),
          'isbn13' => $this->input->post('isbn13'),
          'isbn10' => $this->input->post('isbn10'),
          'thumbnail' => "/blob/".$imgUpload['file_name']
        );
        $this->book_model->insert($book);

        redirect('/books');
      }

    }
  }
}