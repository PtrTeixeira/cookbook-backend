import Inferno from 'inferno'
import h from 'inferno-hyperscript'


const TestComponent = () => {
    return h('p', 'Hello World!')
}

Inferno.render(
    h(TestComponent),
    document.getElementById('app')
)
