<template>
	<body>
		<div class="main-container">
			<div class="main-logo">
				<img src="../assets/Main-logo.png" />
			</div>
			<div class="greeting">
				<h2 id="welcome"> Making Stronger Bodies One Syntax at a time</h2>
				<p class="about-text">
					Lorem ipsum dolor sit amet, ex sed saepe putent. Id per tollit mollis
					persius, ex vis nemore pertinax. At usu affert partem eripuit, eum in
					maiorum similique, sanctus facilis accusam no usu. Eu audire persius
					pericula est. Ad has affert necessitatibus.Cu vix insolens molestiae,
					nam ei dicta corpora argumentum.
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
	position: relative;
	min-height: 100%;
	min-width: 100%;
	width: 100%;
	height: 100vh;
	
	
}
body::before {
	content: '';
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-image: linear-gradient(
      180deg,
      rgba(0, 0, 0, 0.5),
      rgba(0, 0, 0, 0.5)
    ),
    url('../assets/Crossfit-home-page.jpg');
	background-position: top center;
	opacity: .9;
	box-shadow: rgba(0, 229, 255, 0.279) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, .3) 0px 18px 36px -18px inset;

}

.main-logo {
	text-align: center;
	position: relative;
}
.greeting {
	position: relative;
	color: rgb(255, 255, 255);
	display: flex;
	justify-content: center;
	margin: 150px;
	flex-direction: column;
	align-items: center;
	padding: 10px;
}

.btn {
	background-color: aquamarine;
	display: inline-block;
	outline: 0;
	border: 0;
	cursor: pointer;
	will-change: box-shadow, transform;
	background: radial-gradient(100% 100% at 100% 0%, #03ffc0 0%, #00e1fe 100%);
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
		0px 7px 13px -3px rgb(45 35 66 / 30%), inset 0px -3px 0px #f700ff;
	transform: translateY(-2px);
}
.btn :active {
	box-shadow: inset 0px 3px 7px #000000;
	transform: translateY(2px);
}

#welcome {
	font-size: 50px;
	text-shadow: 1px 1px  #03ffc0 ;

}
#login {
	text-decoration: none;
	font-weight: bold;
	color: black;
}
.about-text {
	font-size: 25px;
	text-align: center;
	background-color: rgba(49, 49, 49, 0.422);
	text-shadow: 2px 2px black;
}
</style>
