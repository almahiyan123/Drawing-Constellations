//create array of stars and arraylist of connected stars
Star[] stars;
ArrayList<Star> connectedStars;

void setup() {
  //screen size with prompt
  size(600, 600);
  println("To start/restart press any key. You are traveling to a random new set of stars.");
  println("For 'fast travel', hold down any key.");
  //create 300 stars
  stars = new Star[300];
  //create an empty size changing array list of connected stars
  connectedStars = new ArrayList<Star>();
  
  //go through each star in array and set its constructor
  for (int i = 0; i < stars.length; i++) {
    stars[i] = new Star();
  }
}

//when mouse is pressed go through each array star and when mouse point matches star point
//offset by 5 pixels, add it to connected stars, and print out prompt. 
void mousePressed(){
  for(int i = 0; i < stars.length; i++){
    if(dist (mouseX, mouseY, stars[i].x, stars[i].y)<5){
      connectedStars.add(stars[i]);
      println ("Found a star! Click another to connect.");
    }
    
  }
  
}


void draw() {
  //draw for cases
  //when any key is pressed, empty the connected arraylist and reset the screen back to stars
  //then update the stars and show them as usual
  
  if(keyPressed == true){
    connectedStars.clear();
    background(0);
    for (int i = 0; i < stars.length; i++) {
    stars[i] = new Star();
    }
    for (int i = 0; i < stars.length; i++) {
    stars[i].update();
    stars[i].show();
  }
  }
  //draw a line between connected stars 
  for(int i = 1; i<connectedStars.size(); i++){
    
    Star currentStar = connectedStars.get(i);
    Star currentStar2 = connectedStars.get(i-1);
    stroke(255);
    line(currentStar.x, currentStar.y, currentStar2.x, currentStar2.y);
    
  }
  
}

// star class
class Star {
 
  float x;
  float y;


//each star has a random width and height displaced from screen side
  Star() {
    x = random(0, width);

    y = random(0, height);


    
  }
//currently does nothing to stars
  void update() {
   
  }

//draws stars in white and sets their size between 2 and 9 pixels
  void show() {
    fill(255);
    noStroke();
    float rnd = random(2,9);
    ellipse(x, y, rnd, rnd);
  }
}