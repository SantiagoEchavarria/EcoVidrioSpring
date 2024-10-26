document.getElementById('clearBtn').addEventListener('click', function() {
    // Muestra el mensaje
    const message = document.getElementById('message');
    message.style.display = 'block';

    // Oculta el mensaje después de 3 segundos
    setTimeout(function() {
        message.style.display = 'none';
    }, 3000);
});