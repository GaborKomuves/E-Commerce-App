
document.querySelectorAll('.tab-button').forEach(button => {
    button.addEventListener('click', () => {
        document.querySelectorAll('.tab-button').forEach(btn => btn.classList.remove('active'));
        document.querySelectorAll('.tab-content').forEach(content => content.classList.remove('active'));

        button.classList.add('active');
        document.getElementById(button.getAttribute('data-tab')).classList.add('active');
    });
});

// Example logic for tabs (implement data fetching based on your API endpoints)
// High Price Filter
document.getElementById('highPriceFilter').addEventListener('click', () => {
    console.log('Filter by High Price');
    // Fetch data and update products table
});

// Low Stock Filter
document.getElementById('lowStockFilter').addEventListener('click', () => {
    console.log('Filter by Low Stock');
    // Fetch data and update products table
});

// Category Filter
document.getElementById('categoryFilter').addEventListener('click', () => {
    console.log('Filter by Category');
    // Fetch data and update products table
});
