const fs = require('fs').promises
const path = require('path')
const process = require('process')

async function moveTestFile(file, dest) {
  const baseName = path.basename(file)
  if (baseName !== 'junit.xml') {
    return Promise.resolve()
  }

  console.log(`Test file found: ${file}. Moving ...`)
  const srcDir = path.basename(path.dirname(file))
  const destFile = path.join(dest, `${srcDir}.xml`)

  try {
    const result = await fs.copyFile(file, destFile)
    console.log('Moved')
    return result
  } catch (err) {
    console.error('Could not copy file', err)
    return e
  }
}

async function moveTestFiles(src, dest) {
  try {
    const stat = await fs.stat(src)
    if (stat.isFile()) {
      return await moveTestFile(src, dest)
    } else if (stat.isDirectory()) {
      const files = await fs.readdir(src)

      return Promise.all(files.map((file) => {
        const newFile = path.join(src, file)
        return moveTestFiles(newFile, dest)
      }))
    }
  } catch (err) {
    console.log('Could not open directory', err)
    return err
  }
}

async function main() {
  const src = './packages'
  const dest = './tests'

  try {
    await fs.mkdir(dest, { recursive: true })
  } catch (err) {
    console.error('Could not create directory', err)
  }

  return await moveTestFiles(src, dest)
}

main()

