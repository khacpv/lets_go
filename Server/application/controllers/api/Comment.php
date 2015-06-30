<?php defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Book Controller
 */
require APPPATH . '/libraries/REST_Controller.php';
class Comment extends REST_Controller
{

  function __construct()
  {
    // Construct our parent class
    parent::__construct();
    $this->load->model('comment_model');

  }

  public function index_get(){

    $limit = $this->get('limit');
    $offset = $this->get('offset');

    $limit = $limit?$limit:10;
    $offset = $offset?$offset:0;

    $result = array(
      'code' => 200,
      'data' => $this->comment_model->get_comments($limit,$offset)
    );

    $this->response($result, 200);
  }

  // create new comment
  public function index_post(){
    $comment = (object)array(
      "userId" => $this->post('userId'),
      "userName" => $this->post('userName'),
      "bookId" => $this->post('bookId'),
      "bookTitle" => $this->post('bookTitle'),
      "content" => $this->post('content'),
      "image" => $this->post('image'),
      "link" => $this->post('link')
    );

    $this->comment_model->create_comment($comment);
    $result = array(
      'code' => 200,
      'data' => 0
    );

    $this->response($result, 200);
  }

  public function book_get(){
    $bookId = $this->get('bookId');

    $limit = $this->get('limit');
    $offset = $this->get('offset');

    $limit = $limit?$limit:10;
    $offset = $offset?$offset:0;

    $result = array(
      'code' => 200,
      'data' => $this->comment_model->get_bookcomments($bookId,$limit,$offset)
    );

    $this->response($result, 200);
  }

  public function one_get(){
    $commentId = $this->get('id');

    if(!$commentId){
      $this->response(array(),200);
      return;
    }
    $result = array(
      'code' => 200,
      'id' => $commentId,
      'data' => $this->comment_model->get_comment($commentId)
    );

    $this->response($result, 200);
  }


}