# SOAP - Condition management system cow body

SOAP application using the springboot framework

# General

The body condition score is a numerical value between 1 and 9 that is assigned to a cow by
an expert vet while the cows are milked or passed through a chute. The score of
body condition is an indicator that estimates stored body fat and balance
accumulated energy from cows. This indicator influences milk production,
reproduction and health of cows destined for dairy production or meat production. In
In this sense, ISISTAN has developed, through a doctoral scholarship, a system of
estimation of body condition using images of the back of a cow that is passed
through an estimation process. This “estimation process” uses a recognized technique of
Image-based prediction called deep learning. The objective of this work is to use the
concepts of Web Services, both SOAP (partial of the subject) and REST (end of the
subject), and the technological knowledge acquired in the chair to generate a system that
allows you to manage the values ​​predicted by the body condition estimation system.

# Services

- An AI system enters adds a bcs of an animal (mocked).
- A user to register an animal.
- A user associates an animal with a herd.
- A user gets all the information about an animal, including the last bcs.
- A user obtains all the information of a herd, including the average bsc
- A user sets an alert for a specific animal.
- A user sets an alert for a specific herd.