var AWS = require('aws-sdk');

// simple script to schedule summertime on aws cloudwatch.

var cloudwatchevents = new AWS.CloudWatchEvents();
var context;
const LENGTH_OF_DAY = 86400000;

var run = 0;

const SUMMER_PARAM = {
    Name: 'todaysDinnerCronMondaySummer'
};
const WINTER_PARAM = {
    Name: 'todaysDinnerCronMondayWinter'
};

exports.handler = function(event, c){
    context = c;
    
    
    var date = new Date();
    
    var month = date.getMonth();
    var newMonth = month;
    var sundays = 0;
    
    while(newMonth == month){
        
        // sunday is 0
        
        if(date.getDay() === 0){
            sundays++;
        }
    
        date.setTime(date.getTime() + LENGTH_OF_DAY); // goes to next day
        
        newMonth = date.getMonth();
    }
    
    date = new Date();
    
    var lastSunday = date.getDay() === 0 && sundays === 1;
    
    // if this sunday is the last of the month, or last sunday has passed
    if((sundays === 0 || lastSunday) && month === 2){
        enableSummer();
    }else if((sundays === 0 || lastSunday) && month === 9){
        enableWinter();
    }else{
        if(month <= 2 || month >= 9){
            enableWinter();
        }else if(month >= 3 && month <= 9){
            enableSummer();
        }
    }
}

function enableSummer(){
    cloudwatchevents.enableRule(SUMMER_PARAM, log);
    cloudwatchevents.disableRule(WINTER_PARAM, log);
}
function enableWinter(){
    cloudwatchevents.enableRule(WINTER_PARAM, log);
    cloudwatchevents.disableRule(SUMMER_PARAM, log);
}

function log(err, data){
    run++;
    if(run < 2){
        return;
    }
    
    if (err) {
        context.fail(err);
    }else{
        context.succeed(data);
    }
}
