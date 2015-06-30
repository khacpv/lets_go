<?php defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Book Controller
 */
require APPPATH . '/libraries/REST_Controller.php';
class Book extends REST_Controller
{

  function __construct()
  {
    // Construct our parent class
    parent::__construct();
    $this->load->model('book_model');

  }

  public function index_get(){
    $bookId = $this->get('bookId');

    if(!$bookId){
      $this->response(array(),200);
      return;
    }
    $result = array(
      'code' => 200,
      'data' => $this->book_model->get_book($bookId)
    );

    $this->response($result, 200);
  }
}