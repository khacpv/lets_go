<?php
/**
 * Created by PhpStorm.
 * User: khacpham
 * Date: 6/22/15
 * Time: 23:48
 */

class Category_model extends CI_Model{
  private $TABLE_NAME = 'category';

  public function get_categories($search,$limit,$offset)
  {
    if (! $search)
    {
      $query = $this->db->get($this->TABLE_NAME, $limit , $offset);
      return $query->result_array();
    }

    $q = $this->db->select('*')
      ->from($this->TABLE_NAME)
      ->order_by('category')
      ->like('LOWER(category)',strtolower($search))
      ->limit($limit, $offset)
      ->get();
    return $q->result_array();
  }

  public function get_category($categoryId){
    $q = $this->db->select('*')
      ->from($this->TABLE_NAME)
      ->where('id',$categoryId)
      ->get();
    return $q->row();
  }

  public function insert($category){
    $data = array(
      'category' => $category->category
    );
    return $this->db->insert($this->TABLE_NAME, $data);
  }

  public function delete($categoryId){
    $this->db->where('id',$categoryId);
    return $this->db->delete($this->TABLE_NAME);
  }
}