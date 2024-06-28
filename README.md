
## Game of Life Simulation

This project is a simulation of Conway's Game of Life, created using Java and Swing for the graphical user interface. Conway's Game of Life is a cellular automaton devised by the mathematician John Horton Conway in 1970. It consists of a grid of cells that evolve over discrete time steps according to a set of simple rules, creating complex patterns.

### Features

- **Interactive Grid:** Users can toggle cells between alive and dead states by clicking on them.
- **Start/Stop Simulation:** Buttons to start and stop the simulation.
- **Generation Counter:** Displays the current generation of the simulation.
- **Random Generation:** A button to randomly populate the grid with live cells.
- **Resizable Grid:** The grid adjusts to different window sizes.
- **Padding:** Aesthetic padding around the grid for better UI experience.

### Technologies Used

- **Java**
- **Swing**

### How to Run

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/GameOfLife.git
    cd GameOfLife
    ```

2. **Compile the project:**
    ```bash
    javac -d bin src/*.java
    ```

3. **Run the project:**
    ```bash
    java -cp bin Main
    ```

### How to Use

- **Start:** Click the "Start" button to begin the simulation.
- **Stop:** Click the "Stop" button to pause the simulation.
- **Generate:** Click the "Generate" button to randomly populate the grid with live cells. This button is only enabled when the simulation is stopped.
- **Toggle Cells:** Click on any cell to toggle its state between alive and dead. This is only possible when the simulation is stopped.

## Screen Recording

![Watch the video](recordings/recording.mov)

