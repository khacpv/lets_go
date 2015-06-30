<html>
<head>

</head>
<body>
  <h1><?php echo $title;?></h1>
  <?php echo validation_errors(); ?>

  <?php echo form_open('login') ?>

    <label for="username">User Name:</label>
    <input type="input" name="username" value="<?php echo set_value('username'); ?>" size="50"/><br/>

    <label for="password">Password:</label>
    <input type="password" name="password" value="" size="50"/><br/>

    <input type="submit" name="submit" value="Login"/>

  </form>
  <br/>
<a href="./login/register">Register</a>
</body>
</html>
