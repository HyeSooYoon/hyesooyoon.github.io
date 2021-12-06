// ---Utils
var _seed = Date.now();

 function srand(seed) {
  _seed = seed;
}

 function valueOrDefault(var1, var2) {
     return var1 || var2
 }

 function rand(min, max) {
  min = valueOrDefault(min, 0);
  max = valueOrDefault(max, 0);
  _seed = (_seed * 9301 + 49297) % 233280;
  return min + (_seed / 233280) * (max - min);
}

 function numbers(config) {
  var cfg = config || {};
  var min = valueOrDefault(cfg.min, 0);
  var max = valueOrDefault(cfg.max, 100);
  var from = valueOrDefault(cfg.from, []);
  var count = valueOrDefault(cfg.count, 8);
  var decimals = valueOrDefault(cfg.decimals, 8);
  var continuity = valueOrDefault(cfg.continuity, 1);
  var dfactor = Math.pow(10, decimals) || 0;
  var data = [];
  var i, value;

  for (i = 0; i < count; ++i) {
    value = (from[i] || 0) + this.rand(min, max);
    if (this.rand() <= continuity) {
      data.push(Math.round(dfactor * value) / dfactor);
    } else {
      data.push(null);
    }
  }

  return data;
}

 function points(config) {
  const xs = this.numbers(config);
  const ys = this.numbers(config);
  return xs.map((x, i) => ({x, y: ys[i]}));
}

 function bubbles(config) {
  return this.points(config).map(pt => {
    pt.r = this.rand(config.rmin, config.rmax);
    return pt;
  });
}
 
const MONTHS = [
  'January',
  'February',
  'March',
  'April',
  'May',
  'June',
  'July',
  'August',
  'September',
  'October',
  'November',
  'December'
];

 function months(config) {
  var cfg = config || {};
  var count = cfg.count || now;
  var section = cfg.section;
  var values = [];
  var i, value;

  for (i = 1; i < count; ++i) {
    // value = MONTHS[Math.ceil(i) % 12];
    values.push(i);
  }

  return values;
}

const COLORS = [
  '#4dc9f6',
  '#f67019',
  '#f53794',
  '#537bc4',
  '#acc236',
  '#166a8f',
  '#00a950',
  '#58595b',
  '#8549ba'
];

var Color = Chart.helpers.color;

 function color(index) {
  return COLORS[index % COLORS.length];
}

 function transparentize(value, opacity) {
  var alpha = opacity === undefined ? 0.5 : 1 - opacity;  
  return Color(color).alpha(alpha).rgbString();
}

 const CHART_COLORS = {
  red: 'rgb(255, 99, 132)',
  orange: 'rgb(255, 159, 64)',
  yellow: 'rgb(255, 205, 86)',
  green: 'rgb(75, 192, 192)',
  blue: 'rgb(54, 162, 235)',
  purple: 'rgb(153, 102, 255)',
  grey: 'rgb(201, 203, 207)'
};

const NAMED_COLORS = [
  CHART_COLORS.red,
  CHART_COLORS.orange,
  CHART_COLORS.yellow,
  CHART_COLORS.green,
  CHART_COLORS.blue,
  CHART_COLORS.purple,
  CHART_COLORS.grey,
];

 function namedColor(index) {
  return NAMED_COLORS[index % NAMED_COLORS.length];
}

 function newDate(days) {
  return DateTime.now().plus({days}).toJSDate();
}

 function newDateString(days) {
  return DateTime.now().plus({days}).toISO();
}

 function parseISODate(str) {
  return DateTime.fromISO(str);
}

// ---Custom Data. 
var monthNames = [
	{ month: '1', emonth: 'January' }, 
	{ month: '2', emonth: 'February' }, 
	{ month: '3', emonth: 'March' }, 
	{ month: '4', emonth: 'April' }, 
	{ month: '5', emonth: 'May' }, 
	{ month: '6', emonth: 'June' },
	{ month: '7', emonth: 'July' }, 
	{ month: '8', emonth: 'August' }, 
	{ month: '9', emonth: 'September' }, 
	{ month: '10', emonth: 'October' }, 
	{ month: '11', emonth: 'November' }, 
	{ month: '12', emonth: 'December' }
   ];
   
var list = [];
var now = new Date();
var day = now.getMonth() + 1;
var year = now.getFullYear();

// 콜백함수가 처음으로 참이되는 객체를 반환
_.find(monthNames, function(val) {
	
	if(Number(val.month) <= day)
	{
	//   for(i=1; i<=new Date(year, val.month, 0).getDate(); i++) {      
	//    list.push(i);      
	//   }
	   list.push(val.emonth);    
	} 
	
});

// ---Data.
  const DATA_COUNT = day;
  const NUMBER_CFG = {count: 0, min: 0, max: 0};   
  const labels = []; 
  const data = {
    labels: labels,
    datasets: [
      {
        label: '윤혜수',
        data: 0, 
        borderColor: CHART_COLORS.red,
        backgroundColor: transparentize(CHART_COLORS.red, 0.5),
        tension: 0.4,
      }
    //   ,
    //   {
    //     label: 'Dataset 2',
    //     data: numbers(NUMBER_CFG),
    //     borderColor: CHART_COLORS.blue,
    //     backgroundColor: transparentize(CHART_COLORS.blue, 0.5),
    //     tension: 0.2,
    //   }
    ]
  };  
 
// ---Config


const config = {
    type: 'line',
    data: data,
    options: {
      animations: {
        radius: {
          duration: 400,
          easing: 'linear',
          loop: (context) => context.active
        }
      },
      hoverRadius: 12,
      hoverBackgroundColor: 'yellow',
      interaction: {
        mode: 'nearest',
        intersect: false,
        axis: 'x'
      },
      plugins: {
        tooltip: {
          enabled: false
        }
      }
    },
  }; 

// ---Action 

const actions = [
{
    name: 'Randomize',
    handler(chart) {
    chart.data.datasets.forEach(dataset => {
        dataset.data = numbers({count: chart.data.labels.length, min: -100, max: 100});
    });
    chart.update();
    }
},
{
    name: 'Add Dataset',
    handler(chart) {
    const data = chart.data;
    const dsColor = namedColor(chart.data.datasets.length);
    const newDataset = {
        label: 'Dataset ' + (data.datasets.length + 1),
        backgroundColor: transparentize(dsColor, 0.5),
        borderColor: dsColor,
        data: numbers({count: data.labels.length, min: -100, max: 100}),
    };
    chart.data.datasets.push(newDataset);
    chart.update();
    }
},
{
    name: 'Add Data',
    handler(chart) {
    const data = chart.data;
    if (data.datasets.length > 0) {
        data.labels = emdate;

        for (let index = 0; index < data.datasets.length; ++index) {
 
        // 랜덤
        // data.datasets[index].data.push(rand(-100, 100));
        
        // 데이터 값 입력 시작
        // //우울감 -40%
        if(emcd === 'EM01') emcd = -40;        
        // 낙천적 40%
        else if(emcd === 'EM02') emcd = 40;
        // 다혈질 50%
        else if(emcd === 'EM03') emcd = 50;
        // 지독한우울 -80%
        else if(emcd === 'EM04') emcd = -80; 
 
        data.datasets[index].data.push(emcd);
        // 데이터 값 입력 끝

        }

        chart.update();
    }
    }
},
{
    name: 'Remove Dataset',
    handler(chart) {
    chart.data.datasets.pop();
    chart.update();
    }
},
{
    name: 'Remove Data',
    handler(chart) {
    chart.data.labels.splice(-1, 1); // remove the label first

    chart.data.datasets.forEach(dataset => {
        dataset.data.pop();
    });

    chart.update();
    }
}
];
 