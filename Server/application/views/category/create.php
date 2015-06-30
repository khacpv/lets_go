<h2><?php echo $title ?></h2>

<?php echo validation_errors(); ?>

<?php echo form_open_multipart('category/create') ?>
<table>
  <tr>
    <td>
      <label for="category">Category</label>
    </td>
    <td>
      <input type="input" name="category"/><br/>
    </td>
  </tr>

  <tr>
    <td>
      <input type="submit" name="submit" value="Add a new Category"/>
    </td>
  </tr>
</table>
</form>
