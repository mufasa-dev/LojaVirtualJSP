//Contatos

function mostrarContatos() {
        document.getElementById("Contato").className = "animated fadeIn";
	document.getElementById("Contato").style.display = "block";
        document.getElementById("Contato").style.opacity = "100";
        document.getElementById("telaEscura").style.display = "block";
        document.getElementById("Sobre").style.display = "none";
        document.getElementById("Produtos").style.display = "none";
        document.getElementById("Excluir").style.display = "none";
        document.getElementById("Cadastrar").style.display = "none";
        document.getElementById("Alterar").style.display = "none";
        document.getElementById("Vendedores").style.display = "none";
        document.getElementById("Perfil").style.display = "none";
        document.getElementById("Mensagens").style.display = "none";
}

function ocultarContatos() {
        document.getElementById("Contato").className = "sumir";  
	//document.getElementById("Contato").style.display = "none";
        document.getElementById("telaEscura").style.display = "none";
}

function hoverContatos(){
    document.getElementById("btnContato").style.filter = "grayscale(0%)";
}

//Sobre nos

function mostrarSobre() {
        document.getElementById("Sobre").className = "animated fadeIn";
	document.getElementById("Sobre").style.display = "block";
        document.getElementById("telaEscura").style.display = "block";
        document.getElementById("Contato").style.display = "none";
        document.getElementById("Produtos").style.display = "none";
        document.getElementById("Excluir").style.display = "none";
        document.getElementById("Alterar").style.display = "none";
        document.getElementById("Cadastrar").style.display = "none";
        document.getElementById("Vendedores").style.display = "none";
        document.getElementById("Perfil").style.display = "none";
        document.getElementById("Mensagens").style.display = "none";
        document.getElementById('frameSobre').contentWindow.location.reload();
}

function ocultarSobre() {
	document.getElementById("Sobre").className = "sumir";  
        document.getElementById("telaEscura").style.display = "none";
}

function hoverSobre(){
    document.getElementById("btnSobre").style.filter = "grayscale(0%)";
}

//Produtos

function mostrarProduto() {
        document.getElementById("Produtos").className = "animated fadeIn";
	document.getElementById("Produtos").style.display = "block";
        document.getElementById("telaEscura").style.display = "block";
        document.getElementById("Contato").style.display = "none";
        document.getElementById("Sobre").style.display = "none";
        document.getElementById("Excluir").style.display = "none";
        document.getElementById("Cadastrar").style.display = "none";
        document.getElementById("Alterar").style.display = "none";
        document.getElementById("Vendedores").style.display = "none";
        document.getElementById("Perfil").style.display = "none";
        document.getElementById("Mensagens").style.display = "none";
        document.getElementById('frameProdutos').contentWindow.location.href = "BuscarProdutosController";
}

function ocultarProduto() {
	document.getElementById("Produtos").className = "sumir";  
        document.getElementById("telaEscura").style.display = "none";
}

function hoverProduto(){
    document.getElementById("btnProduto").style.filter = "grayscale(0%)";
}

function recarregarProdutos() {
        window.parent.document.getElementById('frameProdutos').contentWindow.location.href = "BuscarProdutosController";
        window.parent.document.getElementById('frameCadastrar').contentWindow.location.href = "Cadastrar.jsp";
}

//Cadastrar

function mostrarCadastrar() {
        document.getElementById("Cadastrar").className = "animated fadeIn";
	document.getElementById("Cadastrar").style.display = "block";
        document.getElementById("telaEscura").style.display = "block";
        document.getElementById("Contato").style.display = "none";
        document.getElementById("Sobre").style.display = "none";
        document.getElementById("Produtos").style.display = "none";
        document.getElementById("Excluir").style.display = "none";
        document.getElementById("Alterar").style.display = "none";
        document.getElementById("Vendedores").style.display = "none";
        document.getElementById("Perfil").style.display = "none";
        document.getElementById("Mensagens").style.display = "none";
        document.getElementById('frameCadastrar').contentWindow.location.href = "Cadastrar.jsp";
}

function ocultarCadastrar() {
	document.getElementById("Cadastrar").className = "sumir";  
        document.getElementById("telaEscura").style.display = "none";
}

function hoverCadastrar(){
    document.getElementById("btnCadastrar").style.filter = "grayscale(0%)";
}

//Alterar

function mostrarAlterar() {
        document.getElementById("Alterar").className = "animated fadeIn";
	document.getElementById("Alterar").style.display = "block";
        document.getElementById("telaEscura").style.display = "block";
        document.getElementById("Contato").style.display = "none";
        document.getElementById("Sobre").style.display = "none";
        document.getElementById("Produtos").style.display = "none";
        document.getElementById("Cadastrar").style.display = "none";
        document.getElementById("Excluir").style.display = "none";
        document.getElementById("Vendedores").style.display = "none";
        document.getElementById("Perfil").style.display = "none";
        document.getElementById("Mensagens").style.display = "none";
        document.getElementById('frameAlterar').contentWindow.location.reload();
}

function ocultarAlterar() {
	document.getElementById("Alterar").className = "sumir";  
        document.getElementById("telaEscura").style.display = "none";
}

function hoverAlterar(){
    document.getElementById("btnAlterar").style.filter = "grayscale(0%)";
}

//Excluir

function mostrarExcluir() {
        document.getElementById("Excluir").className = "animated fadeIn";
	document.getElementById("Excluir").style.display = "block";
        document.getElementById("telaEscura").style.display = "block";
        document.getElementById("Contato").style.display = "none";
        document.getElementById("Sobre").style.display = "none";
        document.getElementById("Produtos").style.display = "none";
        document.getElementById("Cadastrar").style.display = "none";
        document.getElementById("Alterar").style.display = "none";
        document.getElementById("Vendedores").style.display = "none";
        document.getElementById("Perfil").style.display = "none";
        document.getElementById("Mensagens").style.display = "none";
        document.getElementById('frameExcluir').contentWindow.location.reload();
}

function ocultarExcluir() {
        document.getElementById("Excluir").className = "sumir";  
        document.getElementById("telaEscura").style.display = "none";
}

function hoverExcluir(){
    document.getElementById("btnExcluir").style.filter = "grayscale(0%)";
}

//Vendedores

function mostrarVendedores() {
        document.getElementById("Vendedores").className = "animated fadeIn";
	document.getElementById("Vendedores").style.display = "block";
        document.getElementById("telaEscura").style.display = "block";
        document.getElementById("Contato").style.display = "none";
        document.getElementById("Excluir").style.display = "none";
        document.getElementById("Sobre").style.display = "none";
        document.getElementById("Produtos").style.display = "none";
        document.getElementById("Cadastrar").style.display = "none";
        document.getElementById("Alterar").style.display = "none";
        document.getElementById("Perfil").style.display = "none";
        document.getElementById("Mensagens").style.display = "none";
        document.getElementById('frameVendedores').contentWindow.location.href = "BuscarVendedoresController";
}

function ocultarVendedores() {
        document.getElementById("Vendedores").className = "sumir";  
        document.getElementById("telaEscura").style.display = "none";
}

//Perfil

function mostrarPerfil() {
        window.parent.document.getElementById("Perfil").className = "animated fadeIn";
	window.parent.document.getElementById("Perfil").style.display = "block";
        window.parent.document.getElementById("telaEscura").style.display = "block";
        window.parent.document.getElementById("Sobre").style.display = "none";
        window.parent.document.getElementById("Contato").style.display = "none";
        window.parent.document.getElementById("Produtos").style.display = "none";
        window.parent.document.getElementById("Excluir").style.display = "none";
        window.parent.document.getElementById("Cadastrar").style.display = "none";
        window.parent.document.getElementById("Alterar").style.display = "none";
        window.parent.document.getElementById("Vendedores").style.display = "none";
        window.parent.document.getElementById("Mensagens").style.display = "none";
        window.parent.document.getElementById('framePerfil').contentWindow.location.href = "AbrirPerfilController";
}

function ocultarPerfil() {
        window.parent.document.getElementById("Perfil").className = "sumir";  
        window.parent.document.getElementById("telaEscura").style.display = "none";
}

//Mensagens

function mostrarMensagens() {
        window.parent.document.getElementById("Mensagens").className = "animated fadeIn";
	window.parent.document.getElementById("Mensagens").style.display = "block";
        window.parent.document.getElementById("telaEscura").style.display = "block";
        window.parent.document.getElementById("Sobre").style.display = "none";
        window.parent.document.getElementById("Contato").style.display = "none";
        window.parent.document.getElementById("Produtos").style.display = "none";
        window.parent.document.getElementById("Excluir").style.display = "none";
        window.parent.document.getElementById("Cadastrar").style.display = "none";
        window.parent.document.getElementById("Alterar").style.display = "none";
        window.parent.document.getElementById("Vendedores").style.display = "none";
        window.parent.document.getElementById("Perfil").style.display = "none";
        window.parent.document.getElementById('frameMensagens').contentWindow.location.href = "BuscarMensagensController";
}

function ocultarMensagens() {
        window.parent.document.getElementById("Mensagens").className = "sumir";  
        window.parent.document.getElementById("telaEscura").style.display = "none";
}

//Leave botoes
function leaveBTN(){
    document.getElementById("btnContato").style.filter = "grayscale(100%)";
    document.getElementById("btnSobre").style.filter = "grayscale(100%)";
    document.getElementById("btnProduto").style.filter = "grayscale(100%)";
    document.getElementById("btnCadastrar").style.filter = "grayscale(100%)";
    document.getElementById("btnExcluir").style.filter = "grayscale(100%)";
    document.getElementById("btnAlterar").style.filter = "grayscale(100%)";
}

//Alterado
function mostrarAlterado() {
        window.parent.document.getElementById("Alterado").className = "animated fadeIn";
	window.parent.document.getElementById("Alterado").style.display = "block";
        window.parent.document.getElementById("telaEscura2").style.display = "block";
}

function ocultarAlterado() {
	document.getElementById("Alterado").className = "sumir";  
        document.getElementById("telaEscura2").style.display = "none";
}

//Excluido
function mostrarExcluido() {
        window.parent.document.getElementById("Excluido").className = "animated fadeIn";
	window.parent.document.getElementById("Excluido").style.display = "block";
        window.parent.document.getElementById("telaEscura2").style.display = "block";
}

function ocultarExcluido() {
	document.getElementById("Excluido").className = "sumir";  
        document.getElementById("telaEscura2").style.display = "none";
}

//Cadastrado 
function mostrarCadastrado() {
        window.parent.document.getElementById("Cadastrado").className = "animated fadeIn";
	window.parent.document.getElementById("Cadastrado").style.display = "block";
        window.parent.document.getElementById("telaEscura2").style.display = "block";
}

function ocultarCadastrado() {
	document.getElementById("Cadastrado").className = "sumir";  
        document.getElementById("telaEscura2").style.display = "none";
}

//Comprando 
function mostrarComprando() {
        window.parent.document.getElementById("Comprando").className = "animated fadeIn";
	window.parent.document.getElementById("Comprando").style.display = "block";
        window.parent.document.getElementById("telaEscura2").style.display = "block";
}

function ocultarComprando() {
	document.getElementById("Comprando").className = "sumir";  
        document.getElementById("telaEscura2").style.display = "none";
}

//Login

function mostrarLogin() {
        window.parent.document.getElementById("Login").className = "animated fadeIn";
	window.parent.document.getElementById("Login").style.display = "block";
        window.parent.document.getElementById("CadastrarVendedor").style.display = "none";
        window.parent.document.getElementById('frameLogin').contentWindow.location.href = "Login.jsp";
        
}

function mostrarCadastrarVendedor() {
	window.parent.document.getElementById("Login").style.display = "none";
        window.parent.document.getElementById("CadastrarVendedor").style.display = "block";
        window.parent.document.getElementById('frameCadastrarVendedor').contentWindow.location.href = "CadastrarVendedor.jsp";
}

function fecharLogin() {
         window.parent.document.getElementById("Login").className = "sumir";  
         window.parent.document.getElementById("telaEscura2").style.display = "none";
}

function fazerLoggout(){
    window.parent.document.getElementById("telaEscura").style.display = "none";
    window.parent.document.getElementById("telaEscura2").style.display = "block";
    window.parent.document.getElementById("Login").className = "animated fadeIn";
    window.parent.document.getElementById("Login").style.display = "block";
    window.parent.document.getElementById("CadastrarVendedor").style.display = "none";
    window.parent.document.getElementById("Mensagens").style.display = "none";
    window.parent.document.getElementById("Sobre").style.display = "none";
    window.parent.document.getElementById("Contato").style.display = "none";
    window.parent.document.getElementById("Produtos").style.display = "none";
    window.parent.document.getElementById("Excluir").style.display = "none";
    window.parent.document.getElementById("Cadastrar").style.display = "none";
    window.parent.document.getElementById("Alterar").style.display = "none";
    window.parent.document.getElementById("Vendedores").style.display = "none";
    window.parent.document.getElementById("Perfil").style.display = "none";
    window.parent.document.getElementById('frameLogin').contentWindow.location.href = "Login.jsp";
    window.parent.document.getElementById('frameCabecalho').contentWindow.location.href = "Cabecalho.jsp";
}

//Vendedor Cadastrado 
function mostrarVendedorCadastrado() {
        window.parent.document.getElementById("VendedorCadastrado").className = "animated fadeIn";
	window.parent.document.getElementById("VendedorCadastrado").style.display = "block";
        window.parent.document.getElementById("telaEscura3").style.display = "block";
}

function ocultarVendedorCadastrado() {
	document.getElementById("VendedorCadastrado").className = "sumir";  
        document.getElementById("telaEscura3").style.display = "none";
        
}