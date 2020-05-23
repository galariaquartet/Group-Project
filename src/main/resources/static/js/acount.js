var box_customer_info = document.getElementById("customer_info_cont");
var box_order_info = document.getElementById("orders_info_cont");

var profile = document.getElementById("profile");
var orders = document.getElementById("orders");

profile.addEventListener("click", function ()
{
    profile.classList.add('right-border');
    orders.classList.remove('right-border');

    box_customer_info.classList.add('is-visible');
    box_customer_info.classList.remove('is-not-visible');

    box_order_info.classList.add('is-not-visible');
    box_order_info.classList.remove('is-visible');

});


orders.addEventListener("click", function ()
{
    orders.classList.add('right-border');
    profile.classList.remove('right-border');

    box_order_info.classList.add('is-visible');
    box_order_info.classList.remove('is-not-visible');

    box_customer_info.classList.add('is-not-visible');
    box_customer_info.classList.remove('is-visible');

});

