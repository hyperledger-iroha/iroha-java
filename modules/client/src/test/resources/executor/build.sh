#!/bin/bash

cargo +nightly-2024-09-09 build --release -Zbuild-std -Zbuild-std-features=panic_immediate_abort
cp ./target/wasm32-unknown-unknown/release/iroha_java_executor.wasm ../executor.wasm
