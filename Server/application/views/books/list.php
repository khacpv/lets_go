<hr>
<style>
  .tbl-style td{
    border: 1px solid black;
  }
</style>
<table class="tbl-style">
  <thead>
  <tr>
    <td>Id</td>
    <td>Title</td>
    <td>Author</td>
    <td>ISBN13</td>
    <td>Thumbnail</td>
    <td>Tag</td>
    <td>Category</td>
    <td>Description</td>
    <td>Delete</td>
  </tr>
  </thead>
  <tbody class="tbl-style">
  <?php foreach($books['data'] as $book): ?>
  <tr style="border: 1px solid lightgray;">
    <td><?=$book['id']?></td>
    <td><?=$book['title']?></td>
    <td><?=$book['author']?></td>
    <td><?=$book['isbn13']?></td>
    <td><img src="<?=$book['thumbnail']?>" width="50px" height="75px"/></td>
    <td><?=$book['tag']?></td>
    <td><?php
      foreach($categories as $category){
        if($book['categoryId'] == $category['id']){
          echo $category['category'];
        }
      }
      ?></td>
    <td><?=$book['description']?></td>
    <td><a href="/index.php/books/delete/<?php echo $book['id']; ?>">Delete</a></td>
  </tr>
  <?php endforeach; ?>
  </tbody>
</table>