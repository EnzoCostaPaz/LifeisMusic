window.onload = function() {
    document.getElementById('CPFTxt').addEventListener('input', function () {
        this.value = aplicarMascaraCPF(this.value);
    });

    document.getElementById('TelTxt').addEventListener('input', function () {
        this.value = aplicarMascaraTelefone(this.value);
    });

    document.getElementById('CEPTxt').addEventListener('input', function () { // Certifique-se de que o ID está correto
        this.value = aplicarMascaraCEP(this.value);
    });
};
// Máscara para o campo de CPF
function aplicarMascaraCPF(valor) {
    valor = valor.replace(/\D/g, ""); // Remove tudo que não é dígito
    
    if (valor.length <= 9) {
        return valor; // Mantém sem hífen se tiver menos de 10 dígitos
    }

    if (valor.length > 9) {
        valor = valor.substring(0, 11); // Garante que o CPF não exceda 11 dígitos
        valor = valor.replace(/(\d{9})(\d{2})/, "$1-$2"); // Aplica o hífen entre o 9º e 10º dígito
    }

    return valor;
}

// Máscara para o campo de Telefone
function aplicarMascaraTelefone(valor) {
    valor = valor.replace(/\D/g, ""); // Remove tudo que não é dígito
    if (valor.length > 10) {
        valor = valor.replace(/(\d{2})(\d{5})(\d{4})/, "($1) $2-$3");
    } else {
        valor = valor.replace(/(\d{2})(\d{4})(\d{4})/, "($1) $2-$3");
    }
    return valor;
}


// Máscara para o campo de CEP
function aplicarMascaraCEP(valor) {
    valor = valor.replace(/\D/g, ""); // Remove tudo que não é dígito
    
    // Aplicar a máscara apenas se houver ao menos 8 dígitos
    if (valor.length > 5) {
        valor = valor.replace(/(\d{5})(\d{3})/, "$1-$2");
    }
    
    return valor;
}