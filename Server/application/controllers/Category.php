<?php
/**
 * Created by PhpStorm.
 * User: khacpham
 * Date: 6/30/15
 * Time: 17:24
 */

class Category extends CI_Controller
{
  public function __construct()
  {
    parent::__construct();
    $this->load->helper('url');
    $this->load->library('session');

    $this->load->model('category_model');

    if (!$this->session->userdata('email')) {
      header("Location: " . base_url() . "login.html");
    }
  }

  public function index(){
    redirect('/category/create');
  }

  public function create(){
    $this->load->library('form_validation');
    $this->load->helper('form');

    $data['title'] = 'Create a category';
    $data['username'] = $this->session->userdata('username');
    $data['email'] = $this->session->userdata('email');
    $data['categories'] = $this->category_model->get_categories('',100,0);

    $this->form_validation->set_rules('category', 'Category', 'required');

    if ($this->form_validation->run() === FALSE) {
      $this->load->view('templates/header', $data);
      $this->load->view('category/create');
      $this->load->view('category/list',$data);
      $this->load->view('templates/footer');
    }
    else{
      $category = (object)array(
        'category' => $this->input->post('category')
      );
      $this->category_model->insert($category);

      redirect('/category');
    }
  }

  public function delete($categoryId){
    $this->category_model->delete($categoryId);
    redirect('/category');
  }
}