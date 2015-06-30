<?php defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Category Controller
 */
require APPPATH . '/libraries/REST_Controller.php';
class Category extends REST_Controller
{

  function __construct()
  {
    // Construct our parent class
    parent::__construct();
    $this->load->model('category_model');

  }

  public function index_get()
  {
    $search = $this->get('search');
    $limit = $this->get('limit');
    $offset = $this->get('offset');

    $limit = $limit?$limit:10;
    $offset = $offset?$offset:0;

    $result = array(
      'code' => 200,
      'query'=> $search,
      'data'=>$this->category_model->get_categories($search,$limit,$offset)
    );

    $this->response($result, 200);
  }

  public function one_get(){
    $categoryId = $this->get('id');

    if(!$categoryId){
      $this->response(array(),200);
      return;
    }
    $result = array(
      'code' => 200,
      'data' => $this->category_model->get_categories($categoryId)
    );

    $this->response($result, 200);
  }
}