<template>
	<div class="main-container">
		<div class="weekday-selector">
			<weekday-selector @click="getClassList" />
		</div>
		<div class="card-container">
			<class-card
				class="class-card"
				v-bind:classItem="item"
				v-for="item in classFilter"
				:key="item.id"
			/>
		</div>
	</div>
</template>

<script>
import ClassCard from '../components/ClassCard.vue';
import WeekdaySelector from '../components/WeekdaySelector.vue';
import classService from '../services/ClassService.js';
export default {
	name: 'Schedule',
	data() {
		return {
			classList: [],
		};
	},
	components: { ClassCard, WeekdaySelector },
	computed: {
		classFilter() {
			return this.classList.filter((classItem) => {
				const classDate = new Date(classItem.date);
				return (
					this.$store.state.weekdaySelector == classDate.getDay() ||
					this.$store.state.weekdaySelector == 7
				);
			});
		},
	},
	methods: {
		getClassList() {
			classService.getClasses().then((response) => {
				this.classList = response.data;
			});
		},
	},
	created() {
		this.classList = this.$store.state.classList;
	},
	beforeDestroy() {
		classService.getRegisteredClassIds().then((response) => {
			this.$store.commit('SET_CLASS_IDS', response.data);
		});
		classService.getRegisteredClasses().then(response => {
			this.$store.commit('SET_REGISTERED_CLASS_LIST', response.data);
		});
		this.$store.commit('RESET_WEEKDAY_SELECTOR');
	},
};
</script>

<style scoped>
#btn {
	display: grid;
	justify-content: center;
	margin: 1rem;
	align-items: center;
}
.tableCells {
	border: 1;
	padding: 2;
}
body {
	height: 100%;
}
body {
	display: grid;
	grid-auto-columns: 2fr 2fr 2fr;
}

.card-container {
	position: relative;
	display: grid;
	grid-template-columns: repeat(4, 5fr);
	padding: 20px;
	margin-left: 15px;
	margin-top: -20%;
}

.class-card {
	display: grid;
	grid-template-columns: repeat(4, 1fr);
	padding: 20px;
}
</style>
