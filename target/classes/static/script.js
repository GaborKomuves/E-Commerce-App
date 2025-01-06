const openFormButton = document.getElementById('openFormButton');
const productForm = document.getElementById('productForm');
const productsSection = document.getElementById('products');

// Show the form and dim the background
openFormButton.addEventListener('click', () => {
    productForm.classList.add('active');
    productsSection.classList.add('dim');
});

// Hide the form and restore the background when clicking outside the form
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
