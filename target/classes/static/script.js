const openFormButton = document.getElementById('openFormButton');
const productForm = document.getElementById('productForm');
const productsSection = document.getElementById('products');

<<<<<<< Updated upstream
// Show the form and dim the background
=======
>>>>>>> Stashed changes
openFormButton.addEventListener('click', () => {
    productForm.classList.add('active');
    productsSection.classList.add('dim');
});

<<<<<<< Updated upstream
// Hide the form and restore the background when clicking outside the form
=======
>>>>>>> Stashed changes
document.addEventListener('click', (event) => {
    if (
        productForm.classList.contains('active') &&
        !productForm.contains(event.target) &&
        event.target.id !== 'openFormButton'
    ) {
        productForm.classList.remove('active');
        productsSection.classList.remove('dim');
    }
});
<<<<<<< Updated upstream
=======

document.getElementById('form').addEventListener('submit', (event) => {
    event.preventDefault();

    const id = document.getElementById('productId').value;
    const name = document.getElementById('name').value;
    const price = parseFloat(document.getElementById('price').value).toFixed(2);
    const stock = parseInt(document.getElementById('stock').value, 10);
    const description = document.getElementById('description').value;
    const category = document.getElementById('category').value;

    const product = { name, price, stock, description, category };

    const url = id ? `${baseUrl}/${id}` : baseUrl;
    const method = id ? "PUT" : "POST";

    fetch(url, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(product)
    })
        .then(() => loadProducts())
        .catch(error => console.error("Error saving product:", error));

    productForm.classList.remove('active');
    productsSection.classList.remove('dim');
    document.getElementById('form').reset();
});
>>>>>>> Stashed changes
