  //   let count=0;
  //  let id=0;

  //  let str="Rocker Online Plant Nursery Application ";
   
  //  id=setInterval (function(){
  //   let newstr=str[count];
  //   if(count==str.length-1){
  //       count=0;
  //       document.getElementById("textRocker").innerText=null;
  //   }
  //   newstr=str[count];
  //   document.getElementById("textRocker").append(newstr);
  //   count++;
  //  },300);
  let user="admin"

   function checkfun(){
    document.getElementById("slide_menu").style.top="0%"
  }
  function cencel(){
    document.getElementById("slide_menu").style.top="-100%";
  }
  function cencelS(){
    document.getElementById("slide_menu").style.top="-100%";
    document.getElementById("login").style.display="none";
    document.getElementById("signup").style.display="block";
  }
  function cencelL(){
    document.getElementById("slide_menu").style.top="-100%";
    document.getElementById("signup").style.display="none";
    document.getElementById("login").style.display="block";
  }

  function msg_submit(){
    let msg=document.getElementById("msg").value;
    console.log(msg)
  }
  function signupHide(){
    document.getElementById("signup").style.display="none";
  }
  function loginHide(){
    document.getElementById("login").style.display="none";
  }

 function changeToAdmin(){
  document.getElementById("toggleU").innerHTML="Admin"
  document.getElementById("toggleP").innerHTML="Admin"
  document.getElementById("adminToggle").style.backgroundColor="black";
  document.getElementById("adminToggle").style.color="white";
  document.getElementById("customerToggle").style.backgroundColor="transparent";
  document.getElementById("customerToggle").style.color="black";
 }
 function changeToCustomer(){
  document.getElementById("toggleU").innerHTML="Customer"
  document.getElementById("toggleP").innerHTML="Customer"
  document.getElementById("customerToggle").style.backgroundColor="black";
  document.getElementById("customerToggle").style.color="white";
  document.getElementById("adminToggle").style.backgroundColor="transparent";
  document.getElementById("adminToggle").style.color="black";
 }
 function changeToColor(){
  document.getElementById("planterToggle").style.backgroundColor="transparent";
  document.getElementById("planterToggle").style.color="black";
  document.getElementById("plantToggle").style.backgroundColor="transparent";
  document.getElementById("plantToggle").style.color="black";
  document.getElementById("seedToggle").style.backgroundColor="transparent";
  document.getElementById("seedToggle").style.color="black";
  document.getElementById("orderToggle").style.backgroundColor="transparent";
  document.getElementById("orderToggle").style.color="black";
  document.getElementById("profileToggle").style.backgroundColor="transparent";
  document.getElementById("profileToggle").style.color="black";
  event.target.style.backgroundColor="black";
  event.target.style.color="white";
  document.getElementById("addPlanter").style.display="none";
 }

function addPlanterFun(numberMethod){
  document.getElementById("addPlanterData").style.display="none";
  document.getElementById("updatePlanterData").style.display="none";
  document.getElementById("deletePlanterData").style.display="none";
  document.getElementById("getPlanterById").style.display="none";
  document.getElementById("getPlanterByShape").style.display="none";
  document.getElementById("getPlanters").style.display="none";
  document.getElementById("getPlanterByCostRange").style.display="none";
  if(numberMethod==1){
    document.getElementById("addPlanterData").style.display="block";
  }else if(numberMethod==2){
    document.getElementById("updatePlanterData").style.display="block";
  }else if(numberMethod==3){
    document.getElementById("deletePlanterData").style.display="block";
  }else if(numberMethod==4){
    document.getElementById("getPlanterById").style.display="block";
  }else if(numberMethod==5){
    document.getElementById("getPlanterByShape").style.display="block";
  }else if(numberMethod==6){
    document.getElementById("getPlanters").style.display="block";
  }else if(numberMethod==7){
    document.getElementById("getPlanterByCostRange").style.display="block";
  }
}













function loggedIn(name){
  document.getElementById("loginId1").innerHTML=name;
  document.getElementById("loginId2").innerHTML=name;
  document.getElementById("l2").innerHTML="";
  document.getElementById("s2").innerHTML="";
  document.getElementById("l1").innerHTML="";
  document.getElementById("s1").innerHTML="";
}


document.getElementById("signupForm").addEventListener("submit",(event) =>{
  event.preventDefault();
  signupCustomer();
})

async function signupCustomer(){
  console.log("I am in method")
 let form = document.getElementById("signupForm")
let obj={
  customerName:form.cName.value,
  customerEmail:form.cEmail.value,
  customerUsername:form.cUser.value,
  customerPassword:form.cPass.value,
  address:{
    houseNo:form.cHouse.value,
    colony:form.cColony.value,
    city:form.cCity.value,
    state:form.cState.value,
    pincode:form.cPin.value
  }
};
console.log("yes started")
let data = fetch('http://localhost:8888/customer/register',{
  method:'POST',
  body:JSON.stringify(obj),
  headers:{
    'Content-Type':'application/json'
  }

})
console.log("Completed")
let res = await data;
console.log(res);
// .then(data =>
//   console.log(JSON.stringify(data)));
//   console.log("I have done")
 }
