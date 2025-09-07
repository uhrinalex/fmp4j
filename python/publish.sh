#!/bin/bash

# Exit on error
set -e

echo "Cleaning previous builds..."
rm -rf build/ dist/ *.egg-info/

echo "Installing build tools..."
pip install --upgrade build twine

echo "Building package..."
python -m build

echo "Checking package..."
twine check dist/*

echo "Uploading to PyPI..."
twine upload dist/*

echo "✅ Package published successfully!"