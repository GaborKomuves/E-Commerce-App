document.getElementById('productForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const price = parseFloat(document.getElementById('price').value);
    const description = document.getElementById('description').value;
    const stock = parseInt(document.getElementById('stock').value, 10);
    const category = document.getElementById('category').value;

    const product = { name, price, description, stock, category };

    addProductToList(product);

    document.getElementById('productForm').reset();
});

function addProductToList(product) {
    const productList = document.getElementById('productList');

    const productElement = document.createElement('div');
    productElement.innerHTML = `
        <strong>${product.name}</strong>
        <p>Price: $${product.price.toFixed(2)}</p>
        <p>Description: ${product.description}</p>
        <p>Stock: ${product.stock}</p>
        <p>Category: ${product.category}</p>
    `;

    productList.appendChild(productElement);
}
