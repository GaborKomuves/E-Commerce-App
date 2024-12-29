const openFormButton = document.getElementById('openFormButton');
const productForm = document.getElementById('productForm');
const productsSection = document.getElementById('products');
const productTableBody = document.getElementById('productTable').querySelector('tbody');

// Dummy data for demonstration purposes
const products = []; // An array to hold product objects

// Show the form and dim the background
openFormButton.addEventListener('click', () => {
    productForm.classList.add('active'); // Makes the form visible
    productsSection.classList.add('dim'); // Dims the background
});

// Hide the form and restore the background when clicking outside the form
document.addEventListener('click', (event) => {
    if (
        productForm.classList.contains('active') &&
        !productForm.contains(event.target) &&
        event.target.id !== 'openFormButton'
    ) {
        productForm.classList.remove('active'); // Hides the form
        productsSection.classList.remove('dim'); // Restores background opacity
    }
});

// Handle form submission
document.getElementById('form').addEventListener('submit', (event) => {
    event.preventDefault(); // Prevent default form submission

    // Get form data
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    const stock = document.getElementById('stock').value;
    const description = document.getElementById('description').value;
    const category = document.getElementById('category').value; // Get selected category

    // Create a new product object
    const newProduct = {
        id: products.length + 1, // Auto-generate an ID
        name,
        price,
        stock,
        description,
        category,
    };

    // Add the new product to the product list
    products.push(newProduct);

    // Update the product table
    addProductToTable(newProduct);

    // Clear the form fields
    document.getElementById('form').reset();

    // Hide the form
    productForm.classList.remove('active');
    productsSection.classList.remove('dim');
});

// Add a product row to the table
function addProductToTable(product) {
    const row = document.createElement('tr');

    row.innerHTML = `
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.stock}</td>
        <td>${product.description}</td>
        <td>${product.category}</td>
        <td>
            <button onclick="editProduct(${product.id})">Edit</button>
            <button onclick="deleteProduct(${product.id})">Delete</button>
        </td>
    `;

    productTableBody.appendChild(row);
}

// Edit product functionality (to be implemented)
function editProduct(productId) {
    const product = products.find(p => p.id === productId);
    if (product) {
        // Populate the form with the product details
        document.getElementById('name').value = product.name;
        document.getElementById('price').value = product.price;
        document.getElementById('stock').value = product.stock;
        document.getElementById('description').value = product.description;
        document.getElementById('category').value = product.category;

        // Show the form
        productForm.classList.add('active');
        productsSection.classList.add('dim');
    }
}

// Delete product functionality
function deleteProduct(productId) {
    const index = products.findIndex(p => p.id === productId);
    if (index !== -1) {
        // Remove product from the array
        products.splice(index, 1);

        // Refresh the table
        refreshProductTable();
    }
}

// Refresh the product table
function refreshProductTable() {
    productTableBody.innerHTML = ''; // Clear existing rows
    products.forEach(product => addProductToTable(product)); // Re-add all products
}
