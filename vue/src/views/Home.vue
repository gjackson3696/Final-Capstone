<template>
	<body>
		<div class="main-container">
			<div class="main-logo">
				<img src="../assets/Main-logo.png" />
			</div>
			<div class="greeting">
				<h2 id="welcome">Welcome to Crossfit Syntactical</h2>
				<p class="about-text">
					Lorem ipsum dolor sit amet, ex sed saepe putent. Id per tollit mollis
					persius, ex vis nemore pertinax. At usu affert partem eripuit, eum in
					maiorum similique, sanctus facilis accusam no usu. Eu audire persius
					pericula est. Ad has affert necessitatibus.Cu vix insolens molestiae,
					nam ei dicta corpora argumentum. Pri iudicabit moderatius eu. In pro
					voluptua cotidieque eloquentiam, graecis tractatos ne cum, nam modus
					mundi torquatos in. Erant tritani ius at, est an admodum deleniti
					suscipiantur. Eripuit inermis argumentum ne qui. Munere aliquando vim
					ea, mei ea illum omnesque. An per soleat corpora elaboraret, ius adhuc
					insolens id.
				</p>
				<button class="btn">
					<router-link
						id="login"
						v-if="$store.state.token === ''"
						v-bind:to="{ name: 'login' }"
						>Lets Get Started</router-link
					>
				</button>
			</div>
		</div>
	</body>
</template>

<script>
export default {};
</script>

<style scoped>
body {
	background-image: url('../assets/Crossfit-home-page.jpg');
	position: relative;
	min-height: 100%;
	min-width: 100%;
	width: 100%;
	height: 100vh;
	background-repeat: no-repeat;
	background-color: transparent;
	background-size: cover;
    box-shadow: rgb(0, 229, 255, 0.2) 0px 30px 60px -12px inset,
		rgba(1, 187, 255, 1) 0px 18px 36px -18px inset;
}

.main-logo {
	text-align: center;
}
.greeting {
	color: white;
	display: flex;
	justify-content: center;
	margin: 150px;
	flex-direction: column;
	align-items: center;
	/* border: 1px solid; */
	padding: 10px;
	box-shadow: rgb(0, 229, 255, 0.2) 0px 30px 60px -12px inset,
		rgba(1, 187, 255, 1) 0px 18px 36px -18px inset;
	margin-top: 50px;
  background-color: rgba(0, 0, 0, 0.437);
	border-radius: 3px;
}

.btn {
	background-color: aquamarine;
	display: inline-block;
	outline: 0;
	border: 0;
	cursor: pointer;
	will-change: box-shadow, transform;
	background: radial-gradient(100% 100% at 100% 0%, #b900fd 0%, #58d3ff 100%);
	box-shadow: 0px 2px 4px rgb(45 35 66 / 40%),
		0px 7px 13px -3px rgb(45 35 66 / 30%),
		inset 0px -3px 0px rgb(58 65 111 / 50%);
	padding: 0 32px;
	border-radius: 6px;
	color: #fff;
	height: 48px;
	font-size: 18px;
	text-shadow: 0 1px 0 rgb(0 0 0 / 40%);
	transition: box-shadow 0.15s ease, transform 0.15s ease;
}
.btn:hover {
	box-shadow: 0px 4px 8px rgb(45 35 66 / 40%),
		0px 7px 13px -3px rgb(45 35 66 / 30%), inset 0px -3px 0px #00f2ff;
	transform: translateY(-2px);
}
.btn :active {
	box-shadow: inset 0px 3px 7px #000000;
	transform: translateY(2px);
}

#welcome {
	font-size: 60px;
	text-shadow: 5px 5px purple;
	font-weight: bold;
}
#login {
	text-decoration: none;
	font-weight: bold;
	color: black;
}
.about-text {
	font-size: 25px;
	text-align: center;
	font-weight: bold;
	text-shadow: 2px 2px black;
}
</style>
