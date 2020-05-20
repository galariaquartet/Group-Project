console.log("eieieiei");

          var box_customer_info = document.getElementById("customer_info_cont");
          var box_order_info = document.getElementById("orders_info_cont");
          var box_credit_info = document.getElementById("credits_info_cont");

          var profile = document.getElementById("profile");
          var orders = document.getElementById("orders");
          var credits = document.getElementById("credit_card");
  
   profile.addEventListener("click", function()
      {
            profile.classList.add('right-border');
            orders.classList.remove('right-border');
            credits.classList.remove('right-border');


            box_customer_info.classList.add('is-visible');
            box_customer_info.classList.remove('is-not-visible');


            box_order_info.classList.add('is-not-visible');
            box_order_info.classList.remove('is-visible');


            box_credit_info.classList.add('is-not-visible');
            box_credit_info.classList.remove('is-visible');
            console.log("itan none");


        
          })


   orders.addEventListener("click", function()
      {
            orders.classList.add('right-border');
            profile.classList.remove('right-border');
            
            credits.classList.remove('right-border'); 
           
            box_order_info.classList.add('is-visible');
            box_order_info.classList.remove('is-not-visible');

            box_customer_info.classList.add('is-not-visible');
            box_customer_info.classList.remove('is-visible');


            box_credit_info.classList.add('is-not-visible');
            box_credit_info.classList.remove('is-visible');
            console.log("itan none");


         

          })

      credits.addEventListener("click", function()
      {
              credits.classList.add('right-border');
              profile.classList.remove('right-border');
              orders.classList.remove('right-border');
              

              box_credit_info.classList.add('is-visible');
              box_credit_info.classList.remove('is-not-visible');

               box_order_info.classList.add('is-not-visible');
               box_order_info.classList.remove('is-visible');

               box_customer_info.classList.add('is-not-visible');
               box_customer_info.classList.remove('is-visible');


            
           
            
            console.log("itan none");


         

          })






    // document.getElementById("credit_card").addEventListener("click", function()
    //   {
         


    //       if( box_credit_info.style.display =="none")
    //       {
    //         box_credit_info.style.display ="block";
    //         box_order_info.style.display ="none";
    //         box_customer_info.style.display ="none";
            
    //         console.log("itan none");
    //       }
    //       else
    //       {
    //       box_credit_info.style.display ="none";
    //       console.log("den itan ");
    //        }

    //       })