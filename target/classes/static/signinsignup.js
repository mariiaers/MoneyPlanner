const firebaseConfig = {
    apiKey: "AIzaSyA8Ob9SzXWd8RH5GIWI_AoifnNyNw9nLds",
    authDomain: "money-planner-9e534.firebaseapp.com",
    databaseURL: "https://money-planner-9e534-default-rtdb.firebaseio.com",
    projectId: "money-planner-9e534",
    storageBucket: "money-planner-9e534.appspot.com",
    messagingSenderId: "1040856478848",
    appId: "1:1040856478848:web:22f14a84972ebd32ea2265"
  };

  // Inicializar Firebase
 
  firebase.initializeApp(firebaseConfig);
  
  // Inicializar variáveis
 
  //Funcao para registrar
  
  
  function register () {
	
  email = document.getElementById('email').value;
  nome = document.getElementById('nome').value;
  nomeempresa = document.getElementById('nomeempresa').value;
  password = document.getElementById('password').value;
  
  
  // Validar os inputs
  
  	if(validate_email(email) == false || validate_password(password) == false){
		alert('Email ou senha incorretas');
		return;
  	}
  	if (validate_nomes(nome) == false || validate_nomes(nomeempresa) == false){
		alert('Nome ou nome da empresa não podem estar vazios');
		return;
  	}
  
  // Autenticação
  
  alert('cheguei aqui');
  
  firebase.auth().createUserWithEmailAndPassword(email.value, password.value)
	.catch(error => {
    const errorCode = error.code;
    const errorMessage = error.message;
	});   
  } 
 
  
  // Email
  
  
  function validate_email(email) {
	
	expression = /^[^@]+@\w+(\.\w+)+\w$/;
	
  	if (expression.test(email) == true){
    	return true;
  }
  	else{
		return false;
  	}
  }
  
  //Senha
  
  function validate_password(password){
	
	if (password < 6) {
		return false;
		
	} else {
		return true;
	}
  }
  
  // Nome e Nome da empresa
  
  function validate_nomes(field){
	if (field == null){
		return false;
	}
	
	if (field.length <= 0){
		return false;
	} else {
		return true;
	}
}   
