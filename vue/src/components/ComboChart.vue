<template>
	<div class="areaChart" >
		<h1 style="padding-left:80px;">
			View your progress here
		</h1>
		<GChart type="AreaChart" :data="chartData" :options="chartOptions" />
	</div>
</template>

<script>
import { GChart } from 'vue-google-charts';
export default {
	name: 'App',
	components: {
		GChart,
	},
	data() {
		return {

			chartData: [
				['Year', 'Blog', 'Maximum Effort' ],
				['2018', 180, 200],
				['2019', 300, 200],
				['2020', 250, 200],
				['2021', 300, 200],
			],
            
			chartOptions: {
				chart: {
					title: 'Company Performance',
					subtitle: 'blog in total: year',
				},
			},
		};
	},
};
</script>
<style scoped>
.areaChart {
margin-left: 200px;
    position: relative;
    width: 80%;
    margin-top: 60px;
    text-align: center;
    color: white;
    height: 400px;
    background-position: top center;
    border-radius: 5px;
	box-shadow: rgba(0, 229, 255, 0.466) 0px 100px 100px -12px inset,
		rgba(1, 187, 255, 0.3) 0px 18px 36px -18px inset;
	background-repeat: no-repeat;
	background-size: cover;
}
h1{
    text-shadow: 1px 1px black;
    font-size: 60px;
    margin-right: 100px
}
</style>
