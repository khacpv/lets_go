<?php

/**
 * Created by PhpStorm.
 * User: khacpham
 * Date: 6/22/15
 * Time: 15:41
 */
class Login extends CI_Controller
{
  public function __construct()
  {
    parent::__construct();
    $this->load->helper(array('form','url'));

    $this->load->library('form_validation');
    $this->load->library('session');

    $this->load->model('login_model');
  }

  /*
   * login controller
   * **/
  public function index()
  {
    $data['title'] = 'Login';
    $data['username'] = '';
    $data['email'] = '';

    $this->form_validation->set_rules('username', 'User name', 'trim|required|min_length[5]|max_length[12]');
    $this->form_validation->set_rules('password', 'Password', 'trim|required|md5');

    if ($this->form_validation->run() === FALSE) {
      $this->load->view('login/login', $data);
    } else {
      $user = (object)[
        'username' => $this->input->post('username'),
        'password' => $this->input->post('password')
      ];

      $trustUser = $this->login_model->login($user);

      if($trustUser){
        $this->session->set_userdata(array(
          'username' => $trustUser->username,
          'email'=>$trustUser->privateEmail
        ));
        redirect('/books');
      }else{
        redirect('/login');
      }
    }
  }

  /*
   * logout controller
   * **/
  public function logout(){
    $this->session->unset_userdata('data_one');
    $this->session->unset_userdata('data_two');
    $this->session->unset_userdata('data_three');
    $this->session->unset_userdata('data_one');
    $this->session->sess_destroy();
    redirect('/login');
  }

  /*
   * register controller
   * **/
  public function register()
  {
    /*
     * @param 0: name of input
     * @param 1: name error on failure
     * @param 3:
     * **/
    $this->form_validation->set_message('check_username','user name not found');
    $this->form_validation->set_rules('username', 'User name', 'trim|required|min_length[5]|max_length[12]|is_unique[user.username]');
    $this->form_validation->set_rules('password', 'Password', 'trim|required|matches[passconf]|md5');
    $this->form_validation->set_rules('passconf', 'Password Confirmation', 'trim|required|md5');
    $this->form_validation->set_rules('email', 'Your email', 'trim|required|valid_email|is_unique[user.privateEmail]');

    if ($this->form_validation->run() === FALSE) {
      $data['title'] = 'Register';
      $this->load->view('login/register');
      $this->load->view('templates/footer');

    } else {
      $user = (object)[
        'username' => $this->input->post('username'),
        'password' => $this->input->post('password'),
        'privateEmail' => $this->input->post('email'),
      ];
      $this->login_model->register($user);
      redirect('/login');
    }
  }
}