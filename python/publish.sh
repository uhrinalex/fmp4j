#!/bin/bash

# Exit on error
set -e

echo "Cleaning previous builds..."
rm -rf build/ dist/ *.egg-info/

echo "Setting up virtual env"
python3 -m venv fmp4j_env
source fmp4j_env/bin/activate

echo "Installing build tools..."
pip3 install --upgrade build twine

echo "Building package..."
python3 -m build

echo "Checking package..."
twine check dist/*

echo "Uploading to PyPI..."
twine upload dist/*

echo "✅ Package published successfully!"