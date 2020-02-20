# TODOs

## Improvements and suggestions

The design is very reliant on knowing the backing tech stack and the specifics on how it works.
The updated structure is an evolution towards a more general testing framework.

Currently only implemented for DatePicker as a proof of concept, You an now use a builder to define the 
target framework (Bootstrap or ToolsQA), set some mandatory fields, and get a date picker that is appropriate 
for the backing framework.  This is accomplished simply through a data picker interface and a factory method that 
can supply the correct date picker.  

|IDatePicker| -> ConcreteDatePicker (for example, com.sdl.selenium.bootstrap.form.DatePicker) 
FormComponent -> correct Parameters -> FormComponentFactory -> Object that implements the IDatePicker interface

As next steps in the evolution of this testing frame work, would be to move more and more of the components to a 
similar structure where they are back by an interface and build on demand.  Once those are done than you can look to
abstract the builder to not be reliant on the concrete objects of the component and finally to a general purpose ui 
framework.  By using Java Reflection libraries you could define the target framework eg bootstrap, and the component eg
DataPicker and then have the code be smart enough to server up a concrete data picker.  For example,
TestComponent.for(bootstrap).withComponent(datePicker).atLocation(location).with(Label:"Label");

The final state of the project I envision one where we move away from even your typical Java notation to a custom
DSL basically do the same as the above paragraph but in a more human readable test language similar to the Gerkin language 
for the Cucumber BDD testing frame work an example would look like: 
Test
    for bootstrap
    with Component datePicker
    at location location
    with Label "Label"
