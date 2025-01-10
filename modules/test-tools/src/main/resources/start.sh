#!/bin/sh

set -e

# Set executor paths
EXECUTOR_RELATIVE_PATH=$(jq -r '.executor' /config/genesis.json)
EXECUTOR_ABSOLUTE_PATH=$(realpath "/config/$EXECUTOR_RELATIVE_PATH")

# Update genesis.json
jq --arg executor "$EXECUTOR_ABSOLUTE_PATH" --argjson topology "$TOPOLOGY" '.executor = $executor | .topology = $topology' /config/genesis.json > /tmp/genesis.json

# Sign the genesis
kagami genesis sign /tmp/genesis.json --public-key "$GENESIS_PUBLIC_KEY" --private-key "$GENESIS_PRIVATE_KEY" --out-file "$GENESIS"

# Start irohad
exec irohad