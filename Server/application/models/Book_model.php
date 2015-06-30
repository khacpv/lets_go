<?php
/**
 * Created by PhpStorm.
 * User: khacpham
 * Date: 6/22/15
 * Time: 22:48
 */

class Book_model extends CI_Model{
  private $TABLE_NAME = 'book';

  public function get_books($search,$limit,$offset)
  {
    if (! $search)
    {
      // search isn't valid
      $c = $this->db->select('*')->order_by('title');
      $q = $c->get($this->TABLE_NAME, $limit , $offset);
      return array(
        'data' => $q->result_array(),
        'count' => $c->get($this->TABLE_NAME)->num_rows()
      );
    }

    // count
    $c = $this->db->select('*')
      ->from($this->TABLE_NAME)
      ->order_by('title')
      ->like('title',$search);

    // query
    $q = $c->limit($limit, $offset)->get();

    return array(
      'data' => $q->result_array(),
      'count' => $c->get($this->TABLE_NAME)->num_rows()
    );
  }

  public function get_book($bookId){
    $q = $this->db->select('*')
      ->from($this->TABLE_NAME)
      ->where('id',$bookId)
      ->get();
    return $q->row();
  }

  public function insert($book){
    $data = array(
      'title' => $book->title,
      'author' => $book->author,
      'description' => $book->description,
      'categoryId' => $book->categoryId,
      'tag' => $book->tag,
      'isbn13' => $book->isbn13,
      'isbn10' => $book->isbn10,
      'thumbnail' => $book->thumbnail
    );
    return $this->db->insert($this->TABLE_NAME, $data);
  }

  public function delete($bookId){
    $this->db->where('id',$bookId);
    return $this->db->delete($this->TABLE_NAME);
  }
}