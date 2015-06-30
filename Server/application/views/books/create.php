<h2><?php echo $title ?></h2>

<?php echo validation_errors(); ?>

<?php echo form_open_multipart('books/create') ?>
<table>
  <tr>
    <td>
      <label for="title">Title</label>
    </td>
    <td>
      <input type="input" name="title"/><br/>
    </td>
  </tr>

  <tr>
    <td>
      <label for="author">Author</label>
    </td>
    <td>
      <input type="input" name="author" placeholder="author1, author2, ..."/><br/>
    </td>
  </tr>


  <tr>
    <td>
      <label for="description">Desc</label>
    </td>
    <td>
      <textarea name="description"></textarea><br/>
    </td>
  </tr>

  <tr>
    <td>
      <label for="category">Category</label>
    </td>
    <td>
      <select name="categoryId">
        <?php foreach ($categories as $category): ?>
          <option value="<?php echo $category['id']?>" <?php if($categoryId == $category['id']) echo "selected"; ?>><?php echo $category['category']?></option>
        <?php endforeach;?>
      </select>
    </td>
  </tr>

  <tr>
    <td>
      <label for="tag">Tag</label>
    </td>
    <td>
      <input type="input" name="tag" placeholder="abc, def, ..."/><br/>
    </td>
  </tr>


  <tr>
    <td>
      <label for="isbn13">ISBN13</label>
    </td>
    <td>
      <input type="input" name="isbn13" placeholder="13 digits"/><br/>
    </td>
  </tr>


  <tr>
    <td>
      <label for="isbn10">ISBN10</label>
    </td>
    <td>
      <input type="input" name="isbn10" placeholder="10 digits"/><br/>
    </td>
    <td>
      (để trống)
    </td>
  </tr>

  <tr>
    <td>
      <label for="thumbnail">thumbnail</label>
    </td>
    <td>
      <span style="color:red;"> <?php echo $error;?></span>
      <input type="file" name="thumbnail" size="20" />
    </td>
    <td>
      <a style="color: blue;">300x450 (tự động resize)</a>
    </td>
  </tr>


  <tr>
    <td>
      <input type="submit" name="submit" value="Add a new Book"/>
    </td>
  </tr>

</table>
</form>
