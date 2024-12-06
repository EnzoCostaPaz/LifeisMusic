<?php
session_start();
session_destroy(); // Destruir a sessão
header("Location: index.php"); // Redirecionar para a página de login
exit();
?>
