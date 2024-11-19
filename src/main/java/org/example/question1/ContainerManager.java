package org.example.question1;

import java.util.ArrayList;
import java.util.List;

public class ContainerManager {
    private List<IMeasurableContainer> containers;

    /** Constructor */
    public ContainerManager() {
        this.containers = new ArrayList<>();
    }

    /**
     * Add into the container
     * @param container | void
     */
    public void add(IMeasurableContainer container) {
        containers.add(container);
    }

    /**
     * returns total weight of the elements into the container
     * @return double
     */
    public double totalWeight() {
        return containers.stream()
                .mapToDouble(IMeasurableContainer::weight)
                .sum();
    }

    /**
     * returns total rectangular volume of the elements into the container
     * @return double
     */
    public double totalRectangularVolume() {
        return containers.stream()
                .mapToDouble(IMeasurableContainer::rectangularVolume)
                .sum();
    }

    public void clearAll() {
        containers.clear();
    }

    /**
     * returns a list of all containers
     * @return List<IMeasurableContainer>
     */
    public List<IMeasurableContainer> getAllContainers() {
        return new ArrayList<>(containers);
    }
}
