<?php

class News extends CI_Controller
{

  public function __construct()
  {
    parent::__construct();
    $this->load->helper('url');
    $this->load->library('session');

    $this->load->model('news_model');

    if (!$this->session->userdata('email')) {
      header("Location: ".base_url()."login.html");
    }
  }

  public function index()
  {
    $data['news'] = $this->news_model->get_news();
    $data['title'] = 'News archive';
    $data['username'] = $this->session->userdata('username');
    $data['email'] = $this->session->userdata('email');

    $this->load->view('templates/header', $data);
    $this->load->view('news/index', $data);
    $this->load->view('templates/footer');
  }

  public function view($slug = NULL)
  {
    $data['username'] = $this->session->userdata('username');
    $data['email'] = $this->session->userdata('email');

    $data['news_item'] = $this->news_model->get_news($slug);

    if (empty($data['news_item'])) {
      show_404();
    }

    $data['title'] = $data['news_item']['title'];

    $this->load->view('templates/header', $data);
    $this->load->view('news/view', $data);
    $this->load->view('templates/footer');
  }

  public function create()
  {
    $this->load->helper('form');
    $this->load->library('form_validation');

    $data['title'] = 'Create a news item';
    $data['username'] = $this->session->userdata('username');
    $data['email'] = $this->session->userdata('email');

    $this->form_validation->set_rules('title', 'Title', 'required');
    $this->form_validation->set_rules('text', 'text', 'required');

    if ($this->form_validation->run() === FALSE) {
      $this->load->view('templates/header', $data);
      $this->load->view('news/create');
      $this->load->view('templates/footer');

    } else {
      $this->news_model->set_news();
      redirect('/news');
    }
  }
}
