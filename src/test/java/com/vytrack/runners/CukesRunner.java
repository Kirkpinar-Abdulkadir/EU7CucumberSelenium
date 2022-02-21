package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                    "html:target/default-html-reports",
                    "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
            glue = "com/vytrack/step_definitions",
        dryRun = false, //to check step definitions existence. does not run the method's code. false olursa kosturur.
        //tags = "@login" //sadece bu tage ship olanlar run edilir.
        //tags = "@driver and @VYT-123" //runs the scenarios that have both tags ((NEW SYNTAX))
        //tags = {"@driver" , "@VYT-123"} ((OLD SYNTAX))
        //tags = "@driver or @store_manager" // runs the scenarios that have either of these tags
        //tags = "@driver , @store_manager" 0LD SYNTAX--> does not match after cucumber version 5
        //tags = "@login and not @wip" //runs all the test cases since the @login tag is at the top but excludes @wip tags
        //tags = {"@login" ,"~@wip"} OLD SYNTAX
        tags = "@wip"

)
public class CukesRunner {
}
