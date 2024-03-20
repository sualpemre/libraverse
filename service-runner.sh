#!/bin/bash

# List of services
services=("api-gateway" "config-server" "service-discovery" "library-service" "account-service")

# Function: Clean and package service
function clean_and_package() {
    echo "Cleaning and packaging in service: [$1]..."
    mvn clean package
    echo "Cleaning and packaging in service: [$1] completed."
}

# Main code
echo "Traversing specified services and running Maven commands..."

# For each service in the list
for dir in "${services[@]}"; do
    # If the specified service exists
    if [ -d "$dir" ]; then
        echo "Directory [$dir] found."
        # Navigate to the service
        cd "$dir" || continue
        # Call the clean_and_package function
        clean_and_package "$dir"
        # Return to the main service
        cd ..
    else
        echo "Service [$dir] not found. Skipping..."
    fi
done

echo "Traversing specified services and running Maven commands completed."