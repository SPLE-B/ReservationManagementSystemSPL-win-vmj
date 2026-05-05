#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE reservationmanagement_product_ayo' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'reservationmanagement_product_ayo') \gexec" | psql "postgresql://:@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://:@localhost/reservationmanagement_product_ayo"
done

java -cp reservationmanagement.product.ayo --module-path reservationmanagement.product.ayo -m reservationmanagement.product.ayo &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait