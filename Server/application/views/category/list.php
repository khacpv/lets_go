<table>
  <tr>
    <?php foreach($categories as $category): ?>
    <td>
      <?php echo $category['category']; ?>
    </td>
    <td>
      <a href="/index.php/category/delete/<?php echo $category['id']; ?>">Delete</a>
    </td>
  </tr>
  <?php endforeach; ?>
</table>