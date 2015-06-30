
<?php echo form_open('login/register'); ?>

<h5>Username</h5>
<span style="color:red;"><?php echo form_error('username'); ?></span>
<input type="text" name="username" value="<?php echo set_value('username'); ?>" size="50"/>

<h5>Password</h5>
<span style="color:red;"><?php echo form_error('password'); ?></span>
<input type="password" name="password" value="<?php echo set_value('password'); ?>" size="50"/>

<h5>Password Confirm</h5>
<input type="password" name="passconf" value="<?php echo set_value('passconf'); ?>" size="50"/>

<h5>Email Address</h5>
<span style="color:red;"><?php echo form_error('email'); ?></span>
<input type="text" name="email" value="<?php echo set_value('email'); ?>" size="50"/>

<div><input type="submit" value="Submit"/></div>

</form>