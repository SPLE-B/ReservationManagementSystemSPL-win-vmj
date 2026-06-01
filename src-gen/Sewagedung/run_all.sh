#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE reservationmanagement_product_sewagedung' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'reservationmanagement_product_sewagedung') \gexec" | psql "postgresql://:@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://:@localhost/reservationmanagement_product_sewagedung"
done

java -cp reservationmanagement.product.sewagedung --module-path reservationmanagement.product.sewagedung -m reservationmanagement.product.sewagedung &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait