<?php defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Book Controller
 */
require APPPATH . '/libraries/REST_Controller.php';

class Books extends REST_Controller
{

  function __construct()
  {
    // Construct our parent class
    parent::__construct();

    // Configure limits on our controller methods. Ensure
    // you have created the 'limits' table and enabled 'limits'
    // within application/config/rest.php
//      $this->methods['user_get']['limit'] = 500; //500 requests per hour per user/key
//      $this->methods['user_post']['limit'] = 100; //100 requests per hour per user/key
//      $this->methods['user_delete']['limit'] = 50; //50 requests per hour per user/key
    $this->load->model('book_model');

  }

  public function index_get()
  {
    $search = $this->get('search');
    $limit = $this->get('limit');
    $offset = $this->get('offset');

    $limit = $limit?$limit:10;
    $offset = $offset?$offset:0;

    $resultQuery = $this->book_model->get_books($search,$limit,$offset);

    $result = array(
      'code' => 200,
      'query'=> $search,
      'limit' => $limit,
      'offset' => $offset,
      'total'=> $resultQuery['count'],
      'data'=> $resultQuery['data']
    );

    $this->response($result, 200);
  }
}
