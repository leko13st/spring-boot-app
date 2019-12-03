<?php
$mysqli = new Mysqli('localhost', 'root', 'leko1311', 'web_bd');
$name = trim($_POST['name']);

$mysqli->query("INSERT INTO `bucket` VALUES (null, '$name')");
?>