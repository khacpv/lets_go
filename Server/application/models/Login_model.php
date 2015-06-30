<?php
/**
 * Created by PhpStorm.
 * User: khacpham
 * Date: 6/22/15
 * Time: 17:08
 */

class Login_model extends CI_Model {

  public function login($user)
  {
    $data = array(
      'username' => $user->username,
      'password' => $user->password
    );

    $this->db->where('username', $data['username']);
    $this->db->where('password', $data['password']);
    $query = $this->db->get('user');
    return $query->row();
  }

  public function register($user)
  {
    $data = array(
      'username' => $user->username,
      'password' => $user->password,
      'privateEmail' => $user->privateEmail
    );

    return $this->db->insert('user', $data);
  }
}
