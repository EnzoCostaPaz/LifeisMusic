 // Função para alternar o menu
 function toggleMenu(menuId, submenuId) {
    const submenu = document.getElementById(submenuId);
    submenu.style.display = submenu.style.display === "block" ? "none" : "block";
}

// Adiciona eventos de clique para cada título
document.getElementById("professor").addEventListener("click", function() {
    toggleMenu("professor", "submenu-professor");
});

document.getElementById("aluno").addEventListener("click", function() {
    toggleMenu("aluno", "submenu-aluno");
});

document.getElementById("instrumento").addEventListener("click", function() {
    toggleMenu("instrumento", "submenu-instrumento");
});