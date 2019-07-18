var wrap = document.getElementById('wrap');
var user = document.getElementById('user');
var manager = document.getElementById('manager');
user.onclick = function(){
	location.pathname = './system/logins.php';
};
manager.onclick = function(){
	location.pathname = './system/login.php';
}