const openFormButton = document.getElementById('openFormButton');
const productForm = document.getElementById('productForm');
const productsSection = document.getElementById('products');

// Show the form and dim the background
openFormButton.addEventListener('click', () => {
    productForm.classList.add('active'); // Makes the form visible
    productsSection.classList.add('dim'); // Dims the background
});

// Hide the form and restore the background when clicking outside the form
document.addEventListener('click', (event) => {
    // Checks if the form is active and the click is outside the form
    if (
        productForm.classList.contains('active') && // Form is active
        !productForm.contains(event.target) && // Click is not inside the form
        event.target.id !== 'openFormButton' // Click is not on the open button
    ) {
        productForm.classList.remove('active'); // Hides the form
        productsSection.classList.remove('dim'); // Restores background opacity
    }
});
